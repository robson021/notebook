import { AppxyzPage } from './app.po';

describe('appxyz App', () => {
  let page: AppxyzPage;

  beforeEach(() => {
    page = new AppxyzPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

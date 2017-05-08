import { StudentCRUDAppClientPage } from './app.po';

describe('student-crud-app-client App', () => {
  let page: StudentCRUDAppClientPage;

  beforeEach(() => {
    page = new StudentCRUDAppClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
